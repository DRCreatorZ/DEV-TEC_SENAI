// Botões + e -
const quantityButtons = document.querySelectorAll('.quantity-button');

quantityButtons.forEach(button => {
    button.addEventListener('click', () => {
        const input = button.parentElement.querySelector('.quantity-input');
        const currentValue = parseInt(input.value);

        if (button.dataset.action === 'increase') {
            input.value = currentValue + 1;
        } else if (button.dataset.action === 'decrease' && currentValue > 1) {
            input.value = currentValue - 1;
        }
    });
});