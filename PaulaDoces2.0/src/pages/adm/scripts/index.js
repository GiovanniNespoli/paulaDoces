document.addEventListener('click', (event) => {

    if (!event.target.matches('#icon') && !event.target.matches('#icon2') && !event.target.matches('#p')) return;
    event.preventDefault();

    const element = document.getElementById('notificationBar');
    const btn = document.getElementById('btn');

    btn.classList.toggle('isOpened');
    element.classList.toggle('isOpened');
}, false);


document.addEventListener('click', (event) => {

    if ( !event.target.matches('#openCloseNav')) return;
    event.preventDefault();

    const element = document.getElementById('nav');

    element.classList.toggle('isClosed');
}), false;