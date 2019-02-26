# Contributing to this Project

This purpose of this class project is to learn and practice standard software engineering techniques. In order to simulate a normal work environment, this repository is set up in a way that requires requests and review of code deploys from [`development`] and [`production`]. The way code should flow from initial creation to deployment is described below.

### Quick Links
- [Production Deploy Pull Request][prod-deploy]

## Creating a New Feature or Bug Fix
### New Features
When a new feature needs to be added to the code, it is recommended to create a new branch for the feature. The branch should start with `feature-` and be followed by a short name for the feature being added.

> Example: If a new feature needs to be added that allows users to signup for the service, a branch called `feature-user-signup` (or a similar name) should be made.

All changes regarding a feature should be on its branch. Changes not explicitly regarding the feature should be kept off its branch if possible.

### Bug Fixes
When a bug fix needs to be added to the code, it is recommended to create a new branch for the bug fix. The branch should start with `bugfix-` and be followed by a short name for bug along with what feature it affects (if possible).

> Example: If a bug is found that allows for SQL injection in a signup form, a branch called `bugfix-sql-injection-user-signup` (or a similar name) should be made.

### Small Changes
If a change is small enough (i.e. changing one line in a file or adding a small fix), it can be committed directly to [`development`]. Care should be taken to make sure the commit has minimal interference to other committers. It is recommended to communicate any interfering changes to other committers.

## Merging Features or Bug Fixes
Features and bug fixes that were created on a separate branch should be merged onto the [`development`] branch when complete and all tests pass. 

Travis CI automatically checks all commits to make sure they build successfully. Each successfully built commit will have a green checkmark next to it on the [commits page](https://github.com/UNO-CSCI4830-SP19-GRP1/Web-App/commits/development) (you may need to switch branches to view specific commits). Information can also be found on the [Travis CI page](https://travis-ci.com/UNO-CSCI4830-SP19-GRP1/Web-App/) for this repository. Please avoid merging into [`development`] if the commits are not passing.

 It is useful to squash and rebase commits before merging to reduce the amount of impact on the git history. Here is a nice guide to follow: [Always Squash and Rebase your Git Commits](https://blog.carbonfive.com/2017/08/28/always-squash-and-rebase-your-git-commits/).

## Deploying Changes to the Development Server
All commits to the [`development`] branch (that pass all tests) are automatically deployed to the development server hosted on [Heroku] within a couple of minutes. You can view current deployments in the [Environments] section of the GitHub repository. The [`development`] branch deploys to [`uno-csci4830-sp19-grp1-dev-app`](https://uno-csci4830-sp19-grp1-dev-app.herokuapp.com/).

## Deploying Changes to the Production Server
When a group of fixes and features on the [`development`] branch are ready to be deployed to the [`production`] branch, a [pull request between the two branches][prod-deploy] should be created. All pull requests to the [`production`] branch will need to be reviewed by the [@UNO-CSCI4830-SP19-GRP1/system-architects]. If a reviewer requests changes, these requested changes should be made (or disputed if necessary). Once all requested changes are made and tests pass, the pull request will be approved or denied. Approved pull requests will be added to the [`production`] branch. You can track the state of production deploys on the [Production Deploy project](https://github.com/UNO-CSCI4830-SP19-GRP1/Web-App/projects/1).

All commits to the [`production`] branch (that pass all tests) are automatically deployed to the production server hosted on [Heroku] within a couple of minutes. You can view current deployments in the [Environments] section of the GitHub repository. The [`production`] branch deploys to [`uno-csci4830-sp19-grp1-web-app`](https://uno-csci4830-sp19-grp1-web-app.herokuapp.com/).

## Deployment Information
If automatic deploying to [Heroku] does not appear to be working, contact the [@UNO-CSCI4830-SP19-GRP1/system-architects].

If you would like to test a pull request on [Heroku] before the request is approved, let the [@UNO-CSCI4830-SP19-GRP1/system-architects] know inside the pull request.

[prod-deploy]: https://github.com/UNO-CSCI4830-SP19-GRP1/Web-App/compare/production...development?quick_pull=1&template=production_pull_request_template.md&title=Deploy:%20[ENTER%20TITLE%20HERE]&projects=UNO-CSCI4830-SP19-GRP1/Web-App/1
[`development`]: https://github.com/UNO-CSCI4830-SP19-GRP1/Web-App/tree/development
[`production`]: https://github.com/UNO-CSCI4830-SP19-GRP1/Web-App/tree/production
[Environments]: https://github.com/UNO-CSCI4830-SP19-GRP1/Web-App/deployments
[@UNO-CSCI4830-SP19-GRP1/system-architects]: https://github.com/orgs/UNO-CSCI4830-SP19-GRP1/teams/system-architects
[Heroku]: https://www.heroku.com/
