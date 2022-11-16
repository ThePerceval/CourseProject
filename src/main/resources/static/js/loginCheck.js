$(document).ready(function () {
    if (window.sessionStorage.getItem("id") == null) {
        location.replace("/login")
    }
});