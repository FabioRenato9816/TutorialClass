window.onload = async function() {
    
    try {
        let res = await $.ajax({
            url: "/api/students",
            method: "get",
            dataType: "text"
        });
        document.getElementById("message").innerHTML = res;

    } catch (error) { console.log(error); }
}

async function Apagar() {
    try {
        let numero = document.getElementById("numero").value;
        let res = await $.ajax({
            url: "/api/students/apagar/" + numero,
            method: "delete",
            dataType: "text"
        });
        document.getElementById("message").innerHTML = res;

        var re = await $.ajax({
            url: "/api/students",
            method: "get",
            dataType: "text"
        });
        document.getElementById("msg1").innerHTML = 'Lista de estudantes atualizada';
        document.getElementById("msg2").innerHTML = re;
        
    }
    
   
        


    
    catch (error) { console.log(error); }
}