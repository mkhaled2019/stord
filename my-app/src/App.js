import React, { Component } from 'react';
import logo from './stord_logo.png';


class App extends Component {
	

	
	constructor(props) {
    super(props);
    this.state = {value: '', name: '', shortUrl: '' , longUrl: '', message: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
	this.redirectURL = this.redirectURL.bind(this);
	
  }
	
	  handleChange(event) {
    this.setState({value: event.target.value});
  }
  
    handleSubmit(event) {
	  event.preventDefault();
	  var obj = { longUrl :this.state.value};
	  let that = this;
	  var x = JSON.stringify(obj);
   const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: x
    };
   
   fetch('/api/url/short', requestOptions)
        .then(response => response.json())
        .then(body => that.setState({ name: '' ,shortUrl:body.shortUrl , message: 'Short URL created, please click to activte'})); 
		
	
		
  }
  
   redirectURL(){
	  let that = this;
const requestOptions = {
        method: 'GET',
        headers: { 'Accept': 'application/json',
        'Content-Type': 'application/json' },
    };
	  const response = fetch('/api/url/long?shortUrl='+this.state.shortUrl, requestOptions)
	    .then(response =>{
			response.json().then(function (body) { 
		that.setState({name: 'http://localhost:3000/'+that.state.shortUrl ,longUrl: body.longUrl , message: ''});
		})}); 
  }

 render() {
    
  return (

    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
       
      </header>
	  
	  <body>
	  
     <form onSubmit={this.handleSubmit}>

		<table>
		<tr>
		<td>
		 URL:<input type="text" value={this.state.value} onChange={this.handleChange}  size="100"/>
		</td>
		<td>
		<input type="submit" value="Submit" />
		</td>
		</tr>
		
		<tr>
		<td>
		<div>		    
			<a
                        className="App-link"
                        target="_blank"
                        
                   onClick = {this.redirectURL} 
					style={{ color: 'red' }}>
                       {this.state.message}
        </a>
           </div>      
		</td>
		</tr>
		
		<tr>
		<td>
		<div>		    
			<a
                        className="App-link"
                        href={this.state.longUrl}
                        target="_blank"
                        
                  
					style={{ color: 'red' }}>
                       {this.state.name}
        </a>
           </div>      
		</td>
		</tr>
		</table>
          
        
      </form>
	  </body>  
    </div>


  );

 }
}

export default App;
