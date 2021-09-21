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

### GPG Signing error
> error: gpg failed to sign the data<br>
> fatal: failed to write commit object

Solution: Kill and restart the gpg agent
```shell
killall gpg-agent
gpg-agent --daemon
git commit -m "try committing again"
```