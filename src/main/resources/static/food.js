import {BACK_URL} from './configModule.js';

const foodBlock = document.querySelector('#food-block');

const user = JSON.parse(sessionStorage.getItem('user'));

const userFood = JSON.parse(sessionStorage.getItem('userFood'));

(async () => {
    const response = await fetch(`${BACK_URL}food`, {
       method: 'GET',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    if(response.status === 200) {
        const food = await response.json();
        foodBlock.innerHTML = `
            ${
                food.map((food) => `
                    <div class="food-one-block">
                        <div class="food">
                            <form method="post" id="food-preference-form">
                                <label class="food-name">${food.name}</label>
                                <div>
                                    <button
                                        type="button"
                                        id="food-like-button-${food.id}"
                                        onclick='likeFood(${user.id},${JSON.stringify(food)});'
                                        class="evaluation-button ${!userFood.find(({name})=>name===food.name)?'disabled':''}"
                                    >
                                        like
                                    </button>
                                    <button
                                        type="button"
                                        id="food-dislike-button-${food.id}"
                                        onclick='dislikeFood(${user.id},${JSON.stringify(food)});'
                                        class="evaluation-button ${!!userFood.find(({name})=>name===food.name)?'disabled':''}"
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