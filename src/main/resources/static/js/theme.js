
// Sets dark/light theme 
document.addEventListener("DOMContentLoaded", () => {
    const toggle = document.getElementById("themeToggle");
    const body = document.body;
    const navbar = document.querySelector('.navbar');
    const cards = document.querySelectorAll('.card');
    const cardHeaders = document.querySelectorAll('.card-header');

    // Set saved preferences
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme === 'dark') {
        body.classList.add('dark-mode');
        navbar.classList.add('dark-mode');
        cards.forEach(c => c.classList.add('dark-mode'));
        cardHeaders.forEach(h => h.classList.add('dark-mode'));
        toggle.checked = true;
    }

    // Changes mode if switch clicked
    toggle.addEventListener('change', () => {
        const isDark = toggle.checked;

        body.classList.toggle('dark-mode', isDark);
        navbar.classList.toggle('dark-mode', isDark);
        cards.forEach(c => c.classList.toggle('dark-mode', isDark));
        cardHeaders.forEach(h => h.classList.toggle('dark-mode', isDark));

        localStorage.setItem('theme', isDark ? 'dark' : 'light');
    });
});
