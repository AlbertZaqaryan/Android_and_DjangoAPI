from django.shortcuts import render
from .models import Human
from rest_framework import viewsets
from .serializers import HumanSerializer
# Create your views here.

class HumanAPI(viewsets.ModelViewSet):

    queryset = Human.objects.all()
    serializer_class = HumanSerializer


