# http://stackoverflow.com/questions/59895/getting-the-source-directory-of-a-bash-script-from-within
DIR_PROJECT="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"/../.. #
(cd $DIR_PROJECT; rm -rf ./target; cd -) #
(cd $DIR_PROJECT; ./batch/linux/compile.sh; cd -) #
(cd $DIR_PROJECT; ./batch/linux/run.sh; cd -) #
(cd $DIR_PROJECT; ./batch/linux/test-spec.sh; cd -) #
(cd $DIR_PROJECT; ./batch/linux/test.sh; cd -) #
(cd $DIR_PROJECT; ./batch/linux/uberjar.sh; cd -) #
