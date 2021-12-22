const path = require('path');

module.exports = {
    entry: './scripts/script.js',
    output: {
        path: path.resolve(__dirname, 'scripts'),
        filename: 'script.bundle.js',
    },
    mode: 'production',
    devtool: "source-map"
};
  