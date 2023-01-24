const user = JSON.parse(sessionStorage.getItem('user'));
const role = user?.role?.name || null;

document.write(
`<header>
    <nav class="main fixed-top">
        <ul>
            ${!user ?
                `<li>
                    <a href="/signIn.html">Войти</a>
                </li>
                <li>
                    <a href="/signUp.html">Зарегистрироваться</a>
                </li>` : ''
            }
            ${user ?
                `<li>
                    <a href="/profile.html">Профиль</a>
                </li>` : ''
            }
            ${role==='ROLE_ADMIN' ?
                `<li>
                <a href="/addAlcohol.html">Добавить алкоголь</a>
                </li>
                <li>
                <a href="/addFood.html">Добавить еду</a>
                </li>` : ''
            }
            ${user ?
                `<li>
                <a href="/newParty.html">Создать вечеринку</a>
                </li>
                <li>
                <a href="/joinParty.html">Войти в вечеринку</a>
                </li>
                <li>
                <a href="/parties.html">Вечеринки</a>
                </li>
                <li>
                <a href="/alcohol.html">Алкоголь</a>
                </li>
                <li>
                <a href="/food.html">Еда</a>
                </li>
                <li>
                <a id="exit-button">Выйти</a>
                </li>` : ''
            }
        </ul>
    </nav>
</header>`
)

const exitButton = document.querySelector("#exit-button");

if(exitButton){
    exitButton.onclick = () => {
        sessionStorage.clear();
        location.assign('/signIn.html');
    }
}
