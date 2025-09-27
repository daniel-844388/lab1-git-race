# Lab 1 Git Race -- Project Report

## Description of Changes
- Time-based greeting: Se ha modificado la clase HelloApiController para que la petición a "/api/hello" responda en función de la momento del día.

- Dark/light-mode: Se ha añadido la posibilidad de activar un modo oscuro. Para ello se ha creado un toggle switch para seleccionar el modo deseado. Se han establecido estilos para modo oscuro en aquellos elementos que se han considerado oportunos. Se establece el cambio de estilos por defectos a estilos de modo oscuro según el toggle switch con javascript en el "themes.js". Además, se guarda el modo establecido en el navegador para recuperarlo cuando se abra/recarge la página de nuevo.

## Technical Decisions
- Se decición usar e implmentar un toggle switch para el modo dark/light porque es intuitivo y estético.
- Se prefirió utilizar clases (.dark-mode) en lugar de sobrescribir estilos inline porque facilita extender el diseño en el futuro.
- Se decidió usar un archivo themes.js que añade o quita la clase dark-mode en lugar de duplicar páginas por sencillez y comodidad, además mantiene la lógica centralizada.

## Learning Outcomes
- He aprendido cómo usar controladores (@RestController y @Controller) y cómo devolver respuestas tanto en HTML como en JSON.
- He aprendido opciones avanzadas que ofrece CSS más allá de estilos básicos.

## AI Disclosure
### AI Tools Used
- ChatGPT

### AI-Assisted Work
- Ayuda para la comprensión del código, sobre todo del manejo de controladores y el uso de plantillas html.
- Consultas sobre sintaxis de Kotlin, JS y CSS.
- Reformular comentarios y documentación.
- 30% código de IA / 70% código propio.

### Original Work
- Comentarios y documentación
- Código para la implementación del saludo personalizado.
- Modificación del toggle switch para adaptarlo a las necesidades.
- Selección de elementos afectados por el modo oscuro y definir sus estilos.
- Código JS para gestionar el cambio de modo (dark/light) (con ayuda).

### Recursos externos
- La base del toggle switch la obtuve de https://www.w3schools.com/howto/howto_css_switch.asp