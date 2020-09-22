function login(){
  alert("hello");
    var username= document.getElementById("user").value;
    var password= document.getElementById("pass").value;
    console.log(username);
(async () => {
    const rawResponse = await fetch('http://localhost:8080/h/user/login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'//pist
      },
      body: JSON.stringify({ "user": username, "password": password }) });
    const content = await rawResponse.json();
  
    console.log(content);
  })();
  return false;
}
