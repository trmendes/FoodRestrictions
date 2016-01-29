### Python script to copy all the https://crowdin.com/project/food-restrictions auto-gen files
### to their right places in this project

import os

#linux home dir
home="/home/tmendes"

#where is your project?
projectdir = "%s/%s"%(home,"Docs/Docs/devel/studio/FoodRestrictions")

#where did you download the files from crowdin project?
basefrom = "%s/%s"%(home,"Downloads/crowdin")

#change the names based on https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
exceptions = {"ne-NP":"ne", "pt-BR":"pt", "zh-CN":"zh", "es-ES":"es", "sv-SE":"sv"}

#Set it as true if you wanna try this script first.
#If true configure the dirs after the "if debug" line
debug=False;

if debug:
    tocopytolangs = "%s/%s"%(home,"Downloads/test/langs")
    tocopytodocs = "%s/%s"%(home,"Downloads/test/docs")
else:
    tocopytolangs = "%s/%s"%(projectdir,"app/src/main/res")
    tocopytodocs = "%s/%s"%(projectdir,"docs")

#function to copy the files to the right places using the right names
def organizefiles(langprefix):
    isexpc = langprefix in exceptions

    print("* Working language: [%s] - Exception [%s]")%(langprefix, isexpc)

    copydir = "%s/%s"%(basefrom,langprefix)
    filetorename = "%s/%s"%(copydir, "google_play_description-en.txt")

    if isexpc:
        langprefix = exceptions[langprefix]

    newlangdir = "%s/values-%s"%(tocopytolangs,langprefix)
    newfilename = "%s/%s-%s.%s"%(tocopytodocs, "google_play_description", langprefix, "txt")

    cmdtoexec = "mkdir -p %s; cp %s/*.xml %s; cp %s %s"%(newlangdir, copydir, newlangdir, filetorename, newfilename)
    print(" - Cmd: [%s]", cmdtoexec)
    os.system(cmdtoexec)

#get the file list from the crowdin directory
languages = os.listdir(basefrom)

#execute the fuction to each directory
for language in languages:
    organizefiles(language)