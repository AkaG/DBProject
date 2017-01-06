var path = require('path');

var autoprefixer = require('autoprefixer');
var Html         = require('html-webpack-plugin');
var webpack      = require('webpack');

var apiUrl     = process.env.npm_package_config_api_url;
var publicPath = process.env.npm_package_config_public_path;

module.exports = {
  context: path.resolve('./src'),
  entry: [
    'babel-polyfill',
    './scripts/index.js',
    './styles/index.scss',
  ],
  module: {
    loaders: [
      {
        test: /\.(jpg|png|woff)$/,
        loader: 'file',
        query: {
          name: 'assets/[hash].[ext]',
        },
      },
    ],
  },
  output: {
    filename: 'script.js',
    path: path.resolve('./build'),
  },
  plugins: [
    new Html({
      minify: {
        collapseWhitespace: true,
      },
      showErrors: false,
      template: './index.html',
    }),
    new webpack.DefinePlugin({
      apiUrl:     JSON.stringify(apiUrl),
      publicPath: JSON.stringify(publicPath),
    }),
  ],
  postcss: function postcss() {
    return [
      autoprefixer,
    ];
  },
  resolve: {
    alias: {
      assets:     path.resolve('./src/assets'),
      scripts:    path.resolve('./src/scripts'),
      styles:     path.resolve('./src/styles'),
      components: path.resolve('./src/scripts/components'),
      consts:     path.resolve('./src/scripts/consts'),
      modules:    path.resolve('./src/scripts/modules'),
      providers:  path.resolve('./src/scripts/providers'),
      utils:      path.resolve('./src/scripts/utils'),
      ui:         path.resolve('./node_modules/react-toolbox/lib'),
    },
  },
};