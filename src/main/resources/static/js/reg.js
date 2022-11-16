$(document).ready(function () {

    $("#regButton").click(function (event) {
        event.preventDefault();
        postRequest();
    });

    function postRequest() {
        fetch('http://localhost:8888/signup', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                login: $("#login").val(),
                password: $("#password").val(),
                name: $("#name").val(),
                surname: $("#surname").val()
            })
        }).then(result => result.json())
            .then(res => console.log(res));
    }

    function redirect(data){
        console.log(data)
        window.sessionStorage.setItem("id", data["id"])
        console.log(window.sessionStorage.getItem("id"))
    }
})

