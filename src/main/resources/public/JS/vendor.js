function vendorSubmit(){
    alert("hello");
      var venName= document.getElementById("vn").value;
      var phNo= document.getElementById("pn").value;
      var state= document.getElementById("state").value;
      var country= document.getElementById("country").value;
      var address1= document.getElementById("address1").value;
      var address2= document.getElementById("address2").value;
      var zipCode= document.getElementById("zc").value;
      
  (async () => {
      const rawResponse = await fetch('http://localhost:8080/h/vendor/add', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*'//pist
        },
        body: JSON.stringify({ "name": "PranzzzzShop",
        "phoneNumber": "98787654311",
        "state": "assam",
        "country": "india",
        "addressLine1": "4c,1st,jidsjvdsv",
        "addressLine2": "nakari",
        "zipCode": "787001" }) });
      const content = await rawResponse.json();
    
      console.log(content);
    })();
    return false;
  }
  