document.addEventListener('click', (event) => {
    if (!event.target.matches('#cakeButton')) return;

    const element = document.getElementById("cakesClosed");

    element.classList.toggle("cakesOpened")

    console.log(element);
}, false);

document.addEventListener('click', (event) => {
    if (!event.target.matches('#btn')) return;

    document.getElementById("popUp").style.display = "block";
}, false);

document.addEventListener('click', (event) => {
    if (!event.target.matches('#cadyButton')) return;

    const element = document.getElementById("candyClosed");

    element.classList.toggle("candyOpened")

    console.log(element);
}, false);

document.addEventListener('click', (event) => {
    if (!event.target.matches('#salgadosButton')) return;

    const element = document.getElementById("salgadosClosed");

    element.classList.toggle("salgadosOpened")

    console.log(element);
}, false);

async function selected(valor, name) {

    var verify = localStorage.getItem(valor);

    const dataValues = JSON.stringify({ valor, name })

    if (verify) {
        console.log("entrou1");
        document.getElementsByName(name).forEach(element => {
            element.style["border"] = "none";
        });
        localStorage.removeItem(valor);
        return valor
    }

    if (!verify) {
        console.log("entrou2");
        document.getElementsByName(name).forEach(element => {
            element.style["border"] = "lightgreen 0.5rem solid";
            element.style["borderRadius"] = "1rem";
        });
        localStorage.setItem(valor, dataValues);
        return valor
    }
}

async function totalValue(valor) {
    console.log(valor);

    console.log(quantidade);
}

