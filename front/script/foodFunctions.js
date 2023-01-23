const likeFood = async (userId, food) => {
    const response = await fetch(`${BACK_URL}food/like/?userId=${userId}&foodId=${food.id}`, {
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    sessionStorage.setItem("userFood", JSON.stringify([...JSON.parse(sessionStorage.getItem("userFood")),food]))
    const foodLikeButton = document.querySelector(`#food-like-button-${food.id}`);
    const foodDislikeButton = document.querySelector(`#food-dislike-button-${food.id}`);
    foodLikeButton.classList.remove('disabled')
    foodDislikeButton.classList.add('disabled')
}

const dislikeFood = async (userId, food) => {
    const response = await fetch(`${BACK_URL}food/dislike/?userId=${userId}&foodId=${food.id}`, {
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    sessionStorage.setItem("userFood", JSON.stringify(JSON.parse(sessionStorage.getItem("userFood")).filter((foodItem)=>foodItem.id !== food.id)))
    const foodLikeButton = document.querySelector(`#food-like-button-${food.id}`);
    const foodDislikeButton = document.querySelector(`#food-dislike-button-${food.id}`);
    foodLikeButton.classList.add('disabled')
    foodDislikeButton.classList.remove('disabled')
}