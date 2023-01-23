import {BACK_URL} from './configModule.js';

const addFoodButton = document.querySelector('#add-food-button');
const addFoodError = document.querySelector('#add-food-error');
const addFoodValidationError = document.querySelector('#add-food-validation-error');

addFoodButton.onclick = async (e) => {
    e.preventDefault();
    const addFoodForm = document.querySelector('#add-food-form');
    const data = Object.fromEntries(new FormData(addFoodForm))
    if(Object.values(data).some(x => x == '')) {
        addFoodError.style.opacity = 0;
        addFoodValidationError.style.opacity = 1;
        return;
    }
    const response = await fetch(`${BACK_URL}food`, {
       body: JSON.stringify(data),
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    if(response.status === 200) {
        const addFoodInput = document.querySelector('#add-food-input');
        addFoodInput.value = '';
    } else if(response.status === 400) {
        addFoodError.style.opacity = 1;
        addFoodValidationError.style.opacity = 0;
    }
}