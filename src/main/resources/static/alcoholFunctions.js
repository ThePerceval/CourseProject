const likeAlcohol = async (userId, alcohol) => {
    const response = await fetch(`${BACK_URL}alcohol/like/?userId=${userId}&alcoholId=${alcohol.id}`, {
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    sessionStorage.setItem("userAlcohol", JSON.stringify([...JSON.parse(sessionStorage.getItem("userAlcohol")),alcohol]))
    const alcoholLikeButton = document.querySelector(`#alcohol-like-button-${alcohol.id}`);
    const alcoholDislikeButton = document.querySelector(`#alcohol-dislike-button-${alcohol.id}`);
    alcoholLikeButton.classList.remove('disabled')
    alcoholDislikeButton.classList.add('disabled')
}

const dislikeAlcohol = async (userId, alcohol) => {
    const response = await fetch(`${BACK_URL}alcohol/dislike/?userId=${userId}&alcoholId=${alcohol.id}`, {
       method: 'POST',
       headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
       },
    })
    sessionStorage.setItem("userAlcohol", JSON.stringify(JSON.parse(sessionStorage.getItem("userAlcohol")).filter((alcoholItem)=>alcoholItem.id !== alcohol.id)))
    const alcoholLikeButton = document.querySelector(`#alcohol-like-button-${alcohol.id}`);
    const alcoholDislikeButton = document.querySelector(`#alcohol-dislike-button-${alcohol.id}`);
    alcoholLikeButton.classList.add('disabled')
    alcoholDislikeButton.classList.remove('disabled')
}