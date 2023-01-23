const username = document.querySelector('#profile-username');
const name = document.querySelector('#profile-name');
const surname = document.querySelector('#profile-surname');
const userFoodElement = document.querySelector('#user-food');
const userAlcoholElement = document.querySelector('#user-alcohol');

const user = JSON.parse(sessionStorage.getItem("user"))
const userFood = JSON.parse(sessionStorage.getItem("userFood"))
const userAlcohol = JSON.parse(sessionStorage.getItem("userAlcohol"))

username.innerHTML = user.username;
name.innerHTML = user.name;
surname.innerHTML = user.surname;
userFoodElement.innerHTML = userFood.map(({name})=>`<div>${name}</div>`).join('');
userAlcoholElement.innerHTML = userAlcohol.map(({name})=>`<div>${name}</div>`).join('');