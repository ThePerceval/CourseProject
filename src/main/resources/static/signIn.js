import {BACK_URL} from './configModule.js';

const signInButton = document.querySelector('#sign-in-button');
const signInError = document.querySelector('#sign-in-error');
const signInValidationError = document.querySelector('#sign-in-validation-error');

signInButton.onclick = async (e) => {
    e.preventDefault();
    const signInForm = document.querySelector('#sign-in-form');
    const data = Object.fromEntries(new FormData(signInForm))
    if(Object.values(data).some(x => x == '')) {
        signInValidationError.style.opacity = 1;
        signInError.style.opacity = 0;
        return;
    }
    const response = await fetch(`${BACK_URL}signIn`, {
       body: JSON.stringify(data),
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    if(response.status === 200) {
        const user = await response.json();
        sessionStorage.setItem("user", JSON.stringify(user))
        console.log(user)
        sessionStorage.setItem("userFood", JSON.stringify(user.foods))
        sessionStorage.setItem("userAlcohol", JSON.stringify(user.alcohols))
        location.assign('profile.html');
    } else if(response.status === 401){
        signInError.style.opacity = 1;
        signInValidationError.style.opacity = 0;
    }
}