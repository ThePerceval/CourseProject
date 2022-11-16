$(document).ready(function () {
    console.log(window.sessionStorage.getItem("id"))

    $("#loginButton").click(function (event) {
        event.preventDefault();
        postRequest();
    });

    function postRequest() {
        fetch('http://localhost:8888/login', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                login: $("#login").val(),
                password: $("#password").val()
            })
        }).then(result => result.json())
            .then(res => redirect(res))
            // .catch(() => alert("Неверный логин или пароль"));
    }

    function redirect(data){
        console.log(data)
        window.sessionStorage.setItem("id", data["id"])
        console.log(window.sessionStorage.getItem("id"))
        location.replace("/profile")
    }
})

