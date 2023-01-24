import {BACK_URL} from './configModule.js';

const alcoholBlock = document.querySelector('#alcohol-block');

const user = JSON.parse(sessionStorage.getItem('user'));

const userAlcohol = JSON.parse(sessionStorage.getItem('userAlcohol'));

(async () => {
    const response = await fetch(`${BACK_URL}alcohol`, {
       method: 'GET',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    if(response.status === 200) {
        const alcohol = await response.json();
        alcoholBlock.innerHTML = `
            ${
                alcohol.map((alcohol) => `
                    <div class="alcohol-one-block">
                        <div class="alcohol">
                            <form method="post" id="alcohol-preference-form">
                                <label class="alcohol-name">${alcohol.name}</label>
                                <div>
                                    <button
                                        type="button"
                                        id="alcohol-like-button-${alcohol.id}"
                                        onclick='likeAlcohol(${user.id},${JSON.stringify(alcohol)});'
                                        class="evaluation-button ${!userAlcohol.find(({name})=>name===alcohol.name)?'disabled':''}"
                                    >
                                        like
                                    </button>
                                    <button
                                        type="button"
                                        id="alcohol-dislike-button-${alcohol.id}"
                                        onclick='dislikeAlcohol(${user.id},${JSON.stringify(alcohol)});'
                                        class="evaluation-button ${!!userAlcohol.find(({name})=>name===alcohol.name)?'disabled':''}"
                                    >
                                        dislike
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                `).join('')
            }
        `
    } else if(response.status === 400) {
    }
})()