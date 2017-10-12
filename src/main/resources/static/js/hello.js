let app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!'
    }
});

axios.get('http://localhost:4567/hello')
    .then((response) => app.message = response.data.text)
    .catch((error) => console.log(error));
