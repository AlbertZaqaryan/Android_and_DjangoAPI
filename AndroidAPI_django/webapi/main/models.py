from django.db import models

# Create your models here.

class Human(models.Model):

    name = models.CharField('Human name', max_length=30)
    age = models.IntegerField('Human age')
