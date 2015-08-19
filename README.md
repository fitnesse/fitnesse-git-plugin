# FitNesse Git Version Controller

This project is a plugin mofule for FitNesse

For those of us who fancy a more tight integration with their source control system there is a Git based version controller available. This version controller creates a commit for every page change. The `.RecentChanges` page can also be tailored to show the Git version history, instead of the default file based history.

To configure the Git version controller, add the following to your plugins.propeties:

    VersionsController=fitnesse.wiki.fs.GitFileVersionsController
    RecentChanges=fitnesse.wiki.fs.GitFileVersionsController

The result is that the files are managed by Git and the Recent changes page is showing those changes.

This version controller takes into account ignored files. If you change a file that is listed as ignored (normally in a `.gitignore` file), it will not be added to version control.
