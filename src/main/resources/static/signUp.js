import {BACK_URL} from './configModule.js';

const signUpButton = document.querySelector('#sign-up-button');
const signUpError = document.querySelector('#sign-up-error');
const signUpValidationError = document.querySelector('#sign-up-validation-error');

signUpButton.onclick = async (e) => {
    e.preventDefault();

    const signUpForm = document.querySelector('#sign-up-form');
    const data = Object.fromEntries(new FormData(signUpForm))
    if(Object.values(data).some(x => x == '')) {
        signUpValidationError.style.opacity = 1;
        signUpError.style.opacity = 0;
        return;
    }
    const response = await fetch(`${BACK_URL}signUp`, {
       body: JSON.stringify(data),
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    if(response.status === 200) {
        location.assign('signIn.html');
    } else if(response.status === 409){
        signUpValidationError.style.opacity = 0;
        signUpError.style.opacity = 1;
    }
}