import {BACK_URL} from './configModule.js';

const addAlcoholButton = document.querySelector('#add-alcohol-button');
const addAlcoholError = document.querySelector('#add-alcohol-error');
const addAlcoholValidationError = document.querySelector('#add-alcohol-validation-error');

addAlcoholButton.onclick = async (e) => {
    e.preventDefault();
    const addAlcoholForm = document.querySelector('#add-alcohol-form');
    const data = Object.fromEntries(new FormData(addAlcoholForm))
    if(Object.values(data).some(x => x == '')) {
        addAlcoholError.style.opacity = 0;
        addAlcoholValidationError.style.opacity = 1;
        return;
    }
    const response = await fetch(`${BACK_URL}alcohol`, {
       body: JSON.stringify(data),
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    if(response.status === 200) {
        const addAlcoholName = document.querySelector('#add-alcohol-name');
        const addAlcoholStrength = document.querySelector('#add-alcohol-strength');
        addAlcoholName.value = '';
        addAlcoholStrength.value = '';
    } else if(response.status === 400) {
        addAlcoholError.style.opacity = 1;
        addAlcoholValidationError.style.opacity = 0;
    }
}