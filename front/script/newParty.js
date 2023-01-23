import {BACK_URL} from './configModule.js';

const newPartyButton = document.querySelector('#new-party-button');
const newPartyError = document.querySelector('#new-party-error');
const newPartyValidationError = document.querySelector('#new-party-validation-error');
const user = JSON.parse(sessionStorage.getItem('user'));

newPartyButton.onclick = async (e) => {
    e.preventDefault();
    const newPartyForm = document.querySelector('#new-party-form');
    const data = Object.fromEntries(new FormData(newPartyForm))
    if(Object.values(data).some(x => x == '')) {
        newPartyValidationError.style.opacity = 1;
        newPartyError.style.opacity = 0;
        return;
    }
    const response = await fetch(`${BACK_URL}party/?id=${user.id}`, {
       body: JSON.stringify(data),
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    if(response.status === 200) {
        location.assign('./parties.html');
    } else if(response.status === 409){
        newPartyError.style.opacity = 1;
        newPartyValidationError.style.opacity = 0;
    }
}