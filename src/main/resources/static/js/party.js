$(document).ready(function () {
    postRequest()

    function postRequest() {
        fetch('http://localhost:8888/allParty', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                id: $().val()
            })
        }).then(result => result.json())
            .then(res => console.log(res));
    }
})

