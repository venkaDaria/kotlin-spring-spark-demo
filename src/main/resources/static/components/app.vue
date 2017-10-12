<template lang="pug">
    div
        h1 {{ message }}
        img(src='../assets/logo.png')
</template>

<script>
    export default {
        name: 'app',
        data() {
            return {
                message: 'Welcome to Your Vue.js App'
            }
        },
        created() {
            axios.get('http://localhost:4567/hello')
                .then((response) => this.message = response.data.text)
                .catch((error) => this.errors.push(e));
        }
    }
</script>

<style lang="scss">
    $primary-color: #43b983;

    h1 {
        color: $primary-color;
    }
</style>
