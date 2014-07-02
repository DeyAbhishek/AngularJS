module.exports = function(grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        //individual plugin configs
        concat: {
            css: {
                src: [
                    'css/*'
                ],
                dest: 'dist/app.styles.css'
            },
            js: {
                src: [
                    'app/**/*.js'
                ],
                dest: 'dist/app.scripts.js'
            }
        },
        cssmin: {
            css: {
                src: 'dist/app.styles.css',
                dest: 'dist/min/app.styles.min.css'
            }
        },
        uglify: {
            js: {
                files: {
                    'dist/min/app.scripts.min.js': ['dist/app.scripts.js']
                }
            }
        },
        watch: {
            files: ['css/*', 'app/**/*.js'],
            tasks: ['concat', 'cssmin', 'uglify']
        }
    });
    //load tasks using grunt.loadNpmTasks()
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-cssmin');

    //register custom tasks using grunt.registerTask()
    grunt.registerTask('default', ['concat:css', 'cssmin:css', 'concat:js', 'uglify:js']);

};
