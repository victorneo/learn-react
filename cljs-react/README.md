# cljs-react

Learning Reagent to build the Comments page from Facebook's
[React tutorial](https://facebook.github.io/react/docs/tutorial.html).

This project was generated from [figwheel-template](https://github.com/bhauman/figwheel-template)
with Reagent.

## Setup

You will need [leiningen](http://leiningen.org/) installed:

    # OS X w/ homebrew
    brew install leiningen

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.
