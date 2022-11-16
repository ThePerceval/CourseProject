$(document).ready(function () {
    $("#logoutButton").click(function (event) {
        event.preventDefault();
        postRequest();
    });

    function postRequest() {
        window.sessionStorage.clear()
        location.replace("/login")
    }
});