from .models import Human
from rest_framework import serializers


class HumanSerializer(serializers.ModelSerializer):

    class Meta:
        model = Human
        fields = '__all__'