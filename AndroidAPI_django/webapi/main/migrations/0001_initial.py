# Generated by Django 5.0.4 on 2024-04-12 11:43

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Human',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=30, verbose_name='Human name')),
                ('age', models.IntegerField(verbose_name='Human age')),
            ],
        ),
    ]
