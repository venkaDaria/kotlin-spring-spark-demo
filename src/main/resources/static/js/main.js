import Vue from 'vue'
import app from '../components/app.vue'

new Vue({
    el: '#app',
    components: { app: app },
    render: function (h) { return h('app'); }
});
