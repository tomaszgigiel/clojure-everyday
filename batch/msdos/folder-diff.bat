cd %~dp0

SET old=..\..\..\clojure-everyday-old\
SET new=..\..\..\clojure-everyday\

diff -x target -x folder-diff.path -x .lein-failures -x .lein-repl-history -x .nrepl-port -x .project -x *.log -ruN %old% %new% > folder-diff.path
pause
