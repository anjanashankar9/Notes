### Working with a fork
Reference: https://www.atlassian.com/git/tutorials/git-forks-and-upstreams

#### Set up an upstream

    git remote add upstream git@bitbucket.org:some-gatekeeper-maintainer/some-project.git

#### Verify remote is added correctly

    git remote -v

#### Fetch from upstream

    git fetch upstream

#### Keeping local master branch upto date with remote

    git checkout master
    git rebase upstream/master

#### Push to local master

    git push

    
#### Standard for importing packages
<standard lib packages>
<space>
<3p packages>
<space>
<external 1p packages, like go-common>
<space>
<internal 1p packages, like skywalker-reporter>