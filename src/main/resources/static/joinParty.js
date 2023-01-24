import {BACK_URL} from './configModule.js';

const joinPartyButton = document.querySelector('#join-party-button');
const user = JSON.parse(sessionStorage.getItem('user'));

const joinPartyAuthError = document.querySelector('#join-party-auth-error');
const joinPartyNotFoundError = document.querySelector('#join-party-not-found-error');
const joinPartyAlreadyError = document.querySelector('#join-party-already-error');
const joinPartyValidationError = document.querySelector('#join-party-validation-error');

joinPartyButton.onclick = async (e) => {
    e.preventDefault();
    const joinPartyForm = document.querySelector('#join-party-form');
    const data = Object.fromEntries(new FormData(joinPartyForm))
    if(Object.values(data).some(x => x == '')) {
        joinPartyAuthError.style.opacity = 0;
        joinPartyNotFoundError.style.opacity = 0;
        joinPartyAlreadyError.style.opacity = 0;
        joinPartyValidationError.style.opacity = 1;
        return;
    }
    const response = await fetch(`${BACK_URL}party/join/?personId=${user.id}&partyId=${data.id}&password=${data.password}`, {
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    if(response.status === 200) {
        const party = await response.json();
        location.assign(`party.html`);
    } else if(response.status === 401){
        joinPartyAuthError.style.opacity = 1;
        joinPartyNotFoundError.style.opacity = 0;
        joinPartyAlreadyError.style.opacity = 0;
        joinPartyValidationError.style.opacity = 0;
    } else if(response.status === 404){
        joinPartyAuthError.style.opacity = 0;
        joinPartyNotFoundError.style.opacity = 1;
        joinPartyAlreadyError.style.opacity = 0;
        joinPartyValidationError.style.opacity = 0;
    } else if(response.status === 409){
        joinPartyAuthError.style.opacity = 0;
        joinPartyNotFoundError.style.opacity = 0;
        joinPartyAlreadyError.style.opacity = 1;
        joinPartyValidationError.style.opacity = 0;
    }
}