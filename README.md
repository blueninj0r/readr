# readr

This is a pretty basic Clojure webapp for reading through blog archives without too much pain. You can get a list of all posts for the given year in ascending order. They are numbered so you can use your mental bookmarking system to remember where you got to.

Assuming the blog supports URLs of the format www.test.com/yyyy/mm you will be able to generate a list using this URL: http://powerful-headland-3387.herokuapp.com/?site=www.site.tld&year=yyyy

For example[http://powerful-headland-3387.herokuapp.com/?site=www.tofugu.com&year=2014](http://powerful-headland-3387.herokuapp.com/?site=www.tofugu.com&year=2014).

This is hosted on a free Heroku instance and there's no caching or fancypants rendering. It will take a few seconds to send you back a page of links.
