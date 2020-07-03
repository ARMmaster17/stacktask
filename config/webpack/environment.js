const { environment } = require('@rails/webpacker')
const webpack = require('webpack')
const typescript =  require('./loaders/typescript')

environment.loaders.prepend('typescript', typescript)

environment.plugins.append('Provide', new webpack.ProvidePlugin({
    $: 'jquery',
    jQuery: 'jquery',
    Popper: ['popper.js', 'default']
}))

module.exports = environment
