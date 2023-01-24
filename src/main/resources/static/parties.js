import {BACK_URL} from './configModule.js';

const partiesBlock = document.querySelector('#parties-block');
const user = JSON.parse(sessionStorage.getItem('user'));

(async () => {
    const response = await fetch(`${BACK_URL}parties/?id=${user.id}`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
    })
    if (response.status === 200) {
        const parties = await response.json();
        partiesBlock.innerHTML = `
            ${
            parties.map(({name, date, place, id}) => `
                    <div class="party-one-block" id="party-container">
                        <div class="party" id="party">
                            <div class="party-param" id="party-name-container">
                                <a href="./party.html?id=${id}" id="party-name">${name}</a>
                            </div>
                            <div class="party-param" id="party-date-container">
                                <p id="party-date">${date}</p>
                            </div>
                            <div class="party-param" id="party-place-container">
                                <p id="party-place">${place}</p>
                            </div>
                        </div>
                    </div>
                `).join('')
        }
        `
    } else if (response.status === 400) {
    }
})()