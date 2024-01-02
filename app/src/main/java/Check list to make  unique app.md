Необходимо поменять имя проекта на нужное в этих файлах:
- удалить origin с помощью команды git remote remove origin и потом добавляем новый репозиторий по желанию git remote add origin git@github.com:Uspesh/app_name
- в strings.xml поменять app_name
- в themes.xml поменять название стиля
- в Theme.kt поменять название функции
- в манифесте поменять все что горит красным
- в build.gradle.kts(app) поменять namespace и applicationId
- в settings.gradle.kts поменять rootProject.name
- переименовать все дериктории(обычную и тестовые)
- переименовать все классы 
- переименовать папку самого проекта

*можно использовать шорткат ctrl+shift+f