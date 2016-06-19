# FitNesse Git Version Controller

[![maven central](https://maven-badges.herokuapp.com/maven-central/org.fitnesse.plugins/fitnesse-git-plugin/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/org.fitnesse.plugins/fitnesse-git-plugin)

This project is a plugin module for [FitNesse](http://fitnesse.org).

For those of us who fancy a more tight integration with their source control system there is a Git based version controller available. This version controller creates a commit for every page change. The `.RecentChanges` page can also be tailored to show the Git version history, instead of the default file based history.

The latest version is available from [Maven Central](https://maven-badges.herokuapp.com/maven-central/org.fitnesse.plugins/fitnesse-git-plugin). You can download the `fitnesse-git-plugin-X.Y-all.jar` file and place it in a directory named `plugins` next to your `FitNesseRoot`, or reference the plugin from a build tool.

To configure the Git version controller, add the following to your plugins.propeties:

    VersionsController=fitnesse.wiki.fs.GitFileVersionsController
    RecentChanges=fitnesse.wiki.fs.GitFileVersionsController

The result is that the files are managed by Git and the Recent changes page is showing those changes.

This version controller takes into account ignored files. If you change a file that is listed as ignored (normally in a `.gitignore` file), it will not be added to version control.

## FAQ

### Which files must be under version control ?

At least your `FitNesseRoot directory must be under version control. I tend to ignore the following files:

* `FitNesseRoot/FitNesse/`
* `FitNesseRoot/RecentChanges/`
* `FitNesseRoot/TemplateLibrary/`
* `FitNesseRoot/files/testResults/`

### Will FitNesse push automatically the changes made in the Git repository?

No. FitNesse will not push the changes. You'll have to do that yourself, since there's a good chance that things need to be merged.

### Will FitNesse pull automatically the changes made in the Git repository? (otherwise is there any way to do that)

No. You'll have to do that yourself.

### What happens in case of merge conflict?

Since FitNesse does not pull or push changes, it does not have to deal with merge conflicts. It's up to the user to resolve those.

### Can I turn of auto committing?

If you do not set the `VersionsController` in your plugins.properties file, FitNesse will not commit on every page change, and you'll have to commit manually. You can still set the `RecentChanges` property as described above to view changes in your repository.

That said, the default version controller is one that creates zip files for every commit, which is something you do not need then. Either provide the option `-e 0` to the command line or
configure the versions controller as follows:

    VersionsController=fitnesse.wiki.fs.SimpleFileVersionsController

This will simply store the pages to disc, but will not do any version management.

### What are the properties I can use to configure the plugin?

At this point there are no properties apart from the ones mentioned above.

### How do I control the commit message? I'd like to put more than a list of changed files

There is currently no way to modify the commit message. PR's are welcome :)


