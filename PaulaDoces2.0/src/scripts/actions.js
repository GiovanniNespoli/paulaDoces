document.addEventListener('click', (event) => {
    if (!event.target.matches('#cakeButton')) return;

    console.log('TRESTE');

    const element = document.getElementById("cakesClosed");

    element.classList.toggle("cakesOpened")

    console.log(element);
}, false);