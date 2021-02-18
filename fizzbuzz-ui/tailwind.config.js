module.exports = {
    purge: ['./pages/**/*.{js,ts,jsx,tsx}', './components/**/*.{js,ts,jsx,tsx}'],
    darkMode: false, // or 'media' or 'class'
    theme: {
        extend: {
            backgroundImage: theme => ({
                'logo-alfresco': "url('/logo-alfresco.png')"
            })
        },
        listStyleType: {
            disc: 'disc'
        }
    },
    variants: {
        extend: {},
    },
    plugins: [],
}
