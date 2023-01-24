import {BACK_URL} from './configModule.js';

const id = new URLSearchParams(location.search).get('id');

const partyUsers = document.querySelector('#party-users');
const partyFoods = document.querySelector('#party-foods');
const partyAlcohol = document.querySelector('#party-alcohol');
const partyName = document.querySelector('#party-name');
const partyPlace = document.querySelector('#party-place');
const partyDate = document.querySelector('#party-date');
const partyId = document.querySelector('#party-id');
const partyPassword = document.querySelector('#party-password');

(async () => {
    const response = await fetch(`${BACK_URL}party/?id=${id}`, {
       method: 'GET',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    // console.log(await response.json())
    if(response.status === 200) {
        const party = await response.json();
        partyFoods.innerHTML = `
            ${
                party.foods.map(({name})=>
                    `<div>
                        <p>${name}</p>
                    </div>`
                ).join('')
            }
        `
        partyAlcohol.innerHTML = `
            ${
                party.alcohols.map(({name})=>
                    `<div>
                        <p>${name}</p>
                    </div>`
                ).join('')
            }
        `
        console.log(party.name)
        partyName.innerHTML = party.name;
        partyPlace.innerHTML = party.place;
        partyDate.innerHTML = party.date;
        partyId.innerHTML = party.id;
        partyPassword.innerHTML = party.password;
    } else if(response.status === 400) {
        location.assign('parties.html');
    }
})()