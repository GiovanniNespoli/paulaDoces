const template = document.createElement('template');

template.innerHTML = `
<link rel="stylesheet" href="/styles/hover/hoverStyles.css">
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        outline: 0ch;
        -webkit-font-smothing: antialiased;
    }

    body {
        background:
            url('../../assets/background.svg') no-repeat;

        background-size: cover;
    }

    header,
    #headerContent {
        display: flex;
        flex-direction: row;
    }

    header {
        width: 100%;
        height: 13vh;
        justify-content: center;
    }


    #headerContent {
        width: 85vw;
        height: 100%;
        justify-content: space-between;
    }


    header #headerContent .teste {
        width: 20%;
        height: 100%;
        display: flex;
        align-items: center;
    }

    header #headerContent .teste img {
        width: 50%;
    }

    header #headerContent nav {
        width: 45%;
        height: 100%;

        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    header #headerContent div h3 {
        color: white;
        font-size: 24px;
        font-family: 'Lato', sans-serif;
        font-weight: 400;

        width: 40%;
        text-align: center;
    }

    header #headerContent nav div {
        margin-left: 2rem;
        width: 65%;
    }

    header #headerContent nav div ul {
        width: 100%;
        height: 100%;

        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    header #headerContent nav div ul li {
        list-style-type: none;
        transition: 0.5s;
        padding: 1rem;
        cursor: pointer;
    }

    header #headerContent nav div ul li a {
        text-decoration: none;
        color: #FFF;
        font-size: 1.3rem;
        font-weight: 400;
        font-family: 'Lato', sans-serif;
    }

    header #headerContent nav button a {
        color: #000;
        font-size: 1rem;
        font-family: 'Lato', sans-serif;
        font-weight: 400;
        text-decoration: underline;
        text-underline-offset: 6px;
    }

    header #headerContent nav button {
        width: 20%;
        height: 40%;

        background-color: #44d8e300;
        border: 1px solid #000;
        border-radius: 5px;

        transition: 0.3s;
        cursor: pointer;
    }

    header #headerContent nav button:hover {
        transform: scale(1.1);
    }


    header #headerContent nav div ul li:hover {
        transform: scale(1.1);
    }
</style>

<header>
        <div id="headerContent">
            <div class="teste">
                <img src="../../../assets/paulaLogo.svg" alt="Logo Paula Doces">
            </div>
            <nav>
                <div>
                    <ul>
                        <li class="hover-underline-animation"><a href="/">Início</a></li>
                        <li class="hover-underline-animation"><a href="produtos">Produtos</a></li>
                        <li class="hover-underline-animation"><a href="sobre">Sobre nós</a></li>
                    </ul>
                </div>
                <button><a href="https://api.whatsapp.com/send?phone=phone number">Contate nos</a></button>
            </nav>
        </div>
    </header>
`;

class Component extends HTMLElement {
    constructor() {
        super();

        this.attachShadow({ mode: 'open' });
        this.shadowRoot.appendChild(template.content.cloneNode(true));

    }
}

if (!customElements.get('header-component')) { customElements.define('header-component', Component); }